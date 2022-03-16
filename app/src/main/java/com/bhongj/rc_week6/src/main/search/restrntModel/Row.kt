package com.bhongj.rc_week6.src.main.search.restrntModel

data class Row(
    val BIZPLC_NM: String,
    val CANCL_DE: Any,
    val DETAIL_ADDR: String,
    val INDUTYPE_DETAIL_NM: String,
    val INDUTYPE_NM: String,
    val REFINE_LOTNO_ADDR: String,
    val REFINE_ROADNM_ADDR: String,
    val REFINE_WGS84_LAT: String,
    val REFINE_WGS84_LOGT: String,
    val REFINE_ZIPNO: String,
    val RM_MATR: Any,
    val SAFETY_RESTRNT_NO: Int,
    val SIDO_NM: String,
    val SIGNGU_NM: String,
    val SLCTN_YN_DIV: String,
    val TELNO: String,
    val UPD_DAY: Any,
    var PIC: Int = 0,
    var RATE: Float = 0f,
)