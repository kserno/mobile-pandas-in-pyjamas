package com.pip.unitskoda.information;

import com.pip.sdk.data.ServerInfoModel;

/**
 * Created by filipsollar on 17.4.18
 */
public interface InformationContract {
    interface Screen {
        void showLoading();
        void showError();
        void showResult(ServerInfoModel serverInfoModel);
    }
    interface Presenter {
        void retryLoading();
        void loadInformation();
    }
}
