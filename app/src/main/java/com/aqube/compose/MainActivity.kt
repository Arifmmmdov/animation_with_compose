package com.aqube.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.motion.widget.MotionScene
import com.aqube.compose.ui.theme.JetpackcomposeTheme
import com.google.android.filament.Box


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
//                UsersApplication()
                AnyBox()
            }
        }
    }

    @Composable
    fun Animated(box: Box, startX: Dp, startY: Dp, endX: Float, endY: Float) {

        val transition = Transition(
            targetState = box,
            startState = Box(
                modifier = Modifier.offset(startX, startY)
            ),
            duration = 1000
        ) {
        }

        transition.start()
    }

    @Composable
    private fun AnyBox() {
        var visible by remember {
            mutableStateOf(true)
        }
        val animatedAlpha by animateFloatAsState(
            targetValue = if (visible) 1.0f else 0f,

            )

        var offset by remember {
            mutableStateOf(0f)
        }
        Column {

            Animated(
                box: Box,
                startX: Float,
                startY: Float,
                endX: Float,
                endY: Float,
            ) {

            }


            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clickable {
                        offset += 100f
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Blue)
            ) {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileListPreview() {
    JetpackcomposeTheme {
        ProfileListScreen(userList, null)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileDetailPreview() {
    JetpackcomposeTheme {
        ProfileDetailsScreen(0, null)
    }
}