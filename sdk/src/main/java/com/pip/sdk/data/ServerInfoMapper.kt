package com.pip.sdk.data

import com.pip.phonexiaapi.data.result.ServerInfoResult
import com.pip.phonexiaapi.data.result.StatusResult
import com.pip.phonexiaapi.data.result.TechnologiesResult

/**
 *  Created by filipsollar on 29.4.18
 */
object ServerInfoMapper {

    @JvmStatic
    fun addServerInfo(serverInfoModel: ServerInfoModel, serverInfoResult: ServerInfoResult) {
        serverInfoModel.isServerInfoLoaded = true

        serverInfoModel.bsapiVersion = serverInfoResult.info.bsapiVersion
        serverInfoModel.buildNumber = serverInfoResult.info.buildNumber
        serverInfoModel.isAudioConverterEnabled = serverInfoResult.info.isAudioConverterEnabled
        serverInfoModel.isHttpStreamsEnabled = serverInfoResult.info.isHttpStreamsEnabled
        serverInfoModel.isRtpStreamsEnabled = serverInfoResult.info.isRtpStreamsEnabled
        serverInfoModel.version = serverInfoResult.info.version
        serverInfoModel.maximumUploadFileSize = serverInfoResult.info.maximumUploadFileSize
        serverInfoModel.maximumUploadMetaFileSize = serverInfoResult.info.maximumUploadMetaFileSize

        serverInfoModel.plugins = serverInfoResult.pluginInfo
    }

    @JvmStatic
    fun addServerStatus(serverInfoModel: ServerInfoModel, statusResult: StatusResult) {
        serverInfoModel.isServerStatusLoaded = true

        serverInfoModel.licenses = statusResult.licenses
        serverInfoModel.internalServices = statusResult.internalServices
        serverInfoModel.database = statusResult.database
    }

    @JvmStatic
    fun addTechnologies(serverInfoModel: ServerInfoModel, technologiesResult: TechnologiesResult) {
        serverInfoModel.isTechnologiesLoaded = true

        serverInfoModel.technologies = technologiesResult.technologies
    }

}