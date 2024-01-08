package com.mike.mvvmdemo

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mike.mvvmdemo.ui.theme.MvvmDemoTheme
// need to import compose runtime
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter(){
    // need to import compose runtime
    // add the folloiwng line to top of file under imports
    // import androidx.compose.runtime.*

    /*
     Composables are stateless by default
     Reason why button does not update when clicked on
     solution: uncomment lines 49-51 and comment out line 52 - then rerun
     */


    // now state being saved ie. b/w recompositions
    // new ui is emitted when composable data changes
    // but wait what happends when switching screening orientation?
    // or switch out of app, data not being preserved...

    // This is where MVVM comes to the rescue

    var counter by remember{
        mutableStateOf(0)
    }
    //var counter:Int = 0



    Button(
        modifier = Modifier
            .fillMaxSize()
            .height(IntrinsicSize.Min)
            .aspectRatio(2f),
        onClick = {
            counter += 1
        }) {
            Text(text = "This button has been clicked ${counter} times.")
        }
}


