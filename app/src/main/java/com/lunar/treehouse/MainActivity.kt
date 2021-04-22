package com.lunar.treehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.roshadgu.treehouse.components.HomeActivity

class MainActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContent{
      Text(text = "Hello World")
      //startActivity()
    }

  }
}