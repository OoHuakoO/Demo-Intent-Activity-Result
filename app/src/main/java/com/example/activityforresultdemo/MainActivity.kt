package com.example.activityforresultdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    companion object{
    private const val FIRST_ACTIVITY_REQUEST_CODE = 1
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_launch_activity_first.setOnClickListener{
            val intent = Intent(this,FirstActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
        {
            if(requestCode == FIRST_ACTIVITY_REQUEST_CODE){
                tv_first_activity_result.text = "First Activity Result Success"
            }
        }
        else if(resultCode == Activity.RESULT_CANCELED){
            Log.e("Cancelled","Cancelled")
            Toast.makeText(this@MainActivity,
                    "ResultCancelled",Toast.LENGTH_SHORT).show()

        }
    }


}