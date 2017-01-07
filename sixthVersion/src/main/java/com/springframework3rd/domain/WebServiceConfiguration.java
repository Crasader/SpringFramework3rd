package com.springframework3rd.domain;

public class WebServiceConfiguration {
    private String webServiceUrl;

    public String getWebServiceUrl() {
        return webServiceUrl;
    }

    public void setWebServiceUrl(String webServiceUrl) {
        this.webServiceUrl = webServiceUrl;
    }

    @Override
    public String toString() {
        return "WebServiceConfiguration{" +
                "webServiceUrl='" + webServiceUrl + '\'' +
                '}';
    }
}
