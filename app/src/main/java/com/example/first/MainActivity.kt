package com.example.first

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var txt: TextView
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRed = findViewById<Button>(R.id.brnRed)
        val buttonBlue = findViewById<Button>(R.id.btnBlue)
        val buttonGray = findViewById<Button>(R.id.btnGray)
        txt = findViewById<TextView>(R.id.txt)

        val linearLayout = findViewById<LinearLayout>(R.id.main)



//        https://attendance-three-flax.vercel.app/api/attendance/getAttendance/bombay/101/percentage/2023-10

        buttonRed.setOnClickListener{
            // change background color of the app to red
            linearLayout.setBackgroundColor(R.color.black)
            getData("101");
        }



        buttonGray.setOnClickListener{
            linearLayout.setBackgroundColor(R.color.gold)
            getData("102");
        }

        buttonBlue.setOnClickListener{
            linearLayout.setBackgroundColor(R.color.gray)
            getData("103");
        }
    }

    private fun getData(btn: String) {
        val call: Call<DataClass>

        when (btn) {
            "101" -> call = RetroFitInstance.apiInterface.getAttendance101()
            "102" -> call = RetroFitInstance.apiInterface.getAttendance102()
            "103" -> call = RetroFitInstance.apiInterface.getAttendance103()
            else -> {
                return
            }
        }

        call.enqueue(object : Callback<DataClass> {
            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                val data = response.body()
                val percentage = data?.Percentage.toString()

                // Update the TextView with the received percentage
                txt.text = "Percentage: $percentage%"
            }

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                println(t.message)
            }
        })
    }


}