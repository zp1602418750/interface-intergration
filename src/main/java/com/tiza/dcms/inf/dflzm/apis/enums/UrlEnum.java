package com.tiza.dcms.inf.dflzm.apis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrlEnum {

    VEHICLE_SERIES("/VsmBasicDataController/selectSeriesInfo"),
    VEHICLE_TYPE("/VsmBasicDataController/selectVehicleCodeInfo"),
    VEHICLE_INFO("/VsmBasicDataController/selectVehicleInfo"),
    PDI("/PvBusinessDataController/uploadPDI2Info"),
    VEHICLE_SERIES_TYPE_RELATION("/VsmBasicDataController/selectSeriesReVehicleCodeInfo");

    final String url;
}
