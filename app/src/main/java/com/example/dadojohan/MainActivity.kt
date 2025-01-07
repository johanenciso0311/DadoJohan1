package com.example.dadojohan

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dadojohan.ui.theme.DadoJohanTheme


class MainActivity : ComponentActivity() {

private val TAG = "MainActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: La actividad ha sido creada.")
        enableEdgeToEdge()
        enableEdgeToEdge()
        setContent {
            DadoJohanTheme {
                DiceRollerApp()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: La actividad está a punto de ser visible. onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: La actividad está ahora interactiva. onResume()  ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: La actividad está a punto de entrar en segundo plano. onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: La actividad ya no es visible. onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: La actividad está siendo reiniciada. onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: La actividad está siendo destruida. onDestroy()")
    }
}
@Preview
@Composable
fun DiceRollerApp() {
 DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center) ) {

    var result by remember { mutableStateOf( 1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(imageResource),
            contentDescription = result.toString())
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
}
}