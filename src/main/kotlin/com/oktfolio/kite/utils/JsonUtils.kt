package com.oktfolio.kite.utils

import com.google.gson.Gson
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */

class JsonUtils {

    companion object {

        private val logger: Logger = LoggerFactory.getLogger(JsonUtils::class.java)
        private val gson = Gson()

        @Throws(IOException::class)
        fun inputStream2Object(inputStream: InputStream, clazz: Class<*>?): Any? {
            try {
                InputStreamReader(inputStream, StandardCharsets.UTF_8)
                        .use { reader -> return gson.fromJson(reader, clazz) }
            } catch (e: Exception) {
                logger.error("failed to read json object from inputStream")
                throw IOException("failed to read json object from inputStream")
            }
        }

    }


}