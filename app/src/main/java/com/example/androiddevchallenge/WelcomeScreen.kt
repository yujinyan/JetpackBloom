package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.BloomTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.white850

@Composable
fun WelcomeScreen(navController: NavController? = null) {
    Box {
        WelcomeBackground()

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.size(72.dp))
            Row {
                Spacer(Modifier.size(88.dp))
                WelcomeIllustration()
            }

            Spacer(Modifier.size(48.dp))
            Logo()
            Text(
                modifier = Modifier.height(32.dp),
                text = "Beautiful home garden solutions",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(Modifier.size(32.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(text = "Create account")
            }
            Spacer(Modifier.size(8.dp))
            TextButton(onClick = {
                navController?.navigate("login")
            }) {
                Text(text = "Log in", color = if (MaterialTheme.colors.isLight) pink900 else white)
            }
        }
    }

}

@Composable
fun WelcomeBackground() = if (MaterialTheme.colors.isLight) {
    Image(painterResource(id = R.drawable.light_welcome_bg), "background")
} else {
    Image(painterResource(id = R.drawable.dark_welcome_bg), "background")
}

@Composable
fun WelcomeIllustration() = if (MaterialTheme.colors.isLight) {
    Image(painterResource(id = R.drawable.light_welcome_illos), "illustration")
} else {
    Image(painterResource(id = R.drawable.dark_welcome_illos), "illustration")
}

@Composable
fun Logo() = if (MaterialTheme.colors.isLight) {
    Image(painterResource(id = R.drawable.light_logo), "logo")
} else {
    Image(painterResource(id = R.drawable.dark_logo), "logo")
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreview() = BloomTheme {
    Surface {
        WelcomeScreen()
    }
}
