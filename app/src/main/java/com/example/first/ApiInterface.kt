package com.example.first

import retrofit2.http.GET

interface ApiInterface {
    @GET("api/attendance/getAttendance/bombay/101/percentage/2023-10")
    fun getAttendance101(): retrofit2.Call<DataClass>

    @GET("api/attendance/getAttendance/bombay/102/percentage/2023-10")
    fun getAttendance102(): retrofit2.Call<DataClass>

    @GET("api/attendance/getAttendance/bombay/103/percentage/2023-10")
    fun getAttendance103(): retrofit2.Call<DataClass>
}