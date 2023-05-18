package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.data.States
import com.example.lemonade.data.statesLemonade

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LemonadeApp()
            }
        }
    }
}

fun machineStateLemonade(stateApp: States): States {
    return when (stateApp) {
        States.LEMON_TREE -> States.LEMON_SQUEEZE
        States.LEMON_SQUEEZE -> States.LEMON_DRINK
        States.LEMON_DRINK -> States.LEMON_RESTART
        States.LEMON_RESTART -> States.LEMON_TREE
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {

    var stateApp by remember { mutableStateOf(States.LEMON_TREE) }
    var randomTaps by remember { mutableStateOf(0) }
    val lemonTreeData = statesLemonade.find { it.state == stateApp }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )

        }
    ) { _ ->
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (lemonTreeData != null) {
                Button(
                    shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    onClick = {
                    stateApp = machineStateLemonade(stateApp)

                    //Random number of time
                    when {
                        stateApp == States.LEMON_SQUEEZE && randomTaps == 0 -> {
                            randomTaps = (2..4).random()
                            stateApp = States.LEMON_SQUEEZE
                        }

                        randomTaps > 0 -> {
                            randomTaps--
                            stateApp = States.LEMON_SQUEEZE
                        }
                    }

                }) {
                    Image(
                        painter = painterResource(id = lemonTreeData.idDrawable),
                        contentDescription = stringResource(lemonTreeData.idContentDescription)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = lemonTreeData.idString),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}