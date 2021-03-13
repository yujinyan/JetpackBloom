/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.BloomTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)

//        window.statusBarColor = 0x00
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

//
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        );
        setContent {
            BloomTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun SystemUi(windows: Window) =
    MaterialTheme {
        windows.statusBarColor = MaterialTheme.colors.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colors.surface.toArgb()

    }


// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController, startDestination = "welcome") {
            composable("welcome") { WelcomeScreen(navController) }
            composable("login") { LoginScreen(navController) }
            composable("home") { HomeScreen() }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    BloomTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    BloomTheme(darkTheme = true) {
        MyApp()
    }
}


@Composable
fun BloomApp(content: @Composable () -> Unit) = BloomTheme {
    Surface(color = MaterialTheme.colors.background) {
        content()
    }
}
