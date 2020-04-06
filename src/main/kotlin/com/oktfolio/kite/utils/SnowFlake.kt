package com.oktfolio.kite.utils

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
class SnowFlake {
    /**
     * 数据中心
     */
    private var dataCenterId: Long
    /**
     * 机器标识
     */
    private var machineId: Long
    /**
     * 序列号
     */
    private var sequence = 0L
    /**
     * 上一次时间戳
     */
    private var lastTimeStamp = -1L

    constructor() {
        dataCenterId = 0L
        machineId = 0L
    }

    constructor(dataCenterId: Long, machineId: Long) {
        require(!(dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0)) { "dataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0" }
        require(!(machineId > MAX_MACHINE_NUM || machineId < 0)) { "machineId can't be greater than MAX_MACHINE_NUM or less than 0" }
        this.dataCenterId = dataCenterId
        this.machineId = machineId
    }

    /**
     * 产生下一个ID
     *
     * @return long
     */
    @Synchronized
    fun nextId(): Long {
        var currTimeStamp = getNewTimeStamp()
        if (currTimeStamp < lastTimeStamp) {
            throw RuntimeException("Clock moved backwards.  Refusing to generate id")
        }
        if (currTimeStamp == lastTimeStamp) { //相同毫秒内，序列号自增
            sequence = sequence + 1 and MAX_SEQUENCE
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currTimeStamp = getNextMill()
            }
        } else { //不同毫秒内，序列号置为0
            sequence = 0L
        }
        lastTimeStamp = currTimeStamp

        return ((currTimeStamp - START_TIME_STAMP).shl(TIMESTAMP_LEFT.toInt()))
                .or((dataCenterId.shl(DATA_CENTER_LEFT.toInt())))
                .or((machineId.shl(MACHINE_LEFT.toInt())))
                .or(sequence)

    }

    private fun getNextMill(): Long {
        var mill = getNewTimeStamp()
        while (mill <= lastTimeStamp) {
            mill = getNewTimeStamp()
        }
        return mill
    }

    private fun getNewTimeStamp(): Long {
        return System.currentTimeMillis()
    }

    fun getDataCenterId(): Long {
        return dataCenterId
    }

    fun setDataCenterId(dataCenterId: Long) {
        this.dataCenterId = dataCenterId
    }

    fun getMachineId(): Long {
        return machineId
    }

    fun setMachineId(machineId: Long) {
        this.machineId = machineId
    }

    companion object {
        /**
         * 起始的时间戳
         */
        private const val START_TIME_STAMP = 1577808000000L
        // 每一部分占用的位数
        /**
         * 序列号占用的位数
         */
        private const val SEQUENCE_BIT: Long = 12
        /**
         * 机器标识占用的位数
         */
        private const val MACHINE_BIT: Long = 5
        /**
         * 数据中心占用的位数
         */
        private const val DATA_CENTER_BIT: Long = 5
        /**
         * 每一部分的最大值
         */
        private const val MAX_DATA_CENTER_NUM = (-1L shl DATA_CENTER_BIT.toInt()).inv()
        private const val MAX_MACHINE_NUM = (-1L shl MACHINE_BIT.toInt()).inv()
        private const val MAX_SEQUENCE = (-1L shl SEQUENCE_BIT.toInt()).inv()
        /**
         * 每一部分向左的位移
         */
        private const val MACHINE_LEFT = SEQUENCE_BIT
        private const val DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT
        private const val TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT
    }
}