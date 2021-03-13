package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.widget.PrimaryButton

private val screenPadding = 16.dp

@Composable
fun LoginScreen(
    navController: NavController? = null
) = Column(
    Modifier.fillMaxHeight(),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    Text(
        text = "Log in with email",
        Modifier.paddingFromBaseline(184.dp),
        style = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.size(16.dp))
    ThisTextField(
        value = "",
        placeholder = "Email Address", onValueChange = { /*TODO*/ })
    Spacer(modifier = Modifier.size(8.dp))
    ThisTextField(
        value = "",
        placeholder = "Password (8+ characters)",
        onValueChange = { /*TODO*/ })

    Text(
        text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .paddingFromBaseline(top = 24.dp)
            .padding(horizontal = screenPadding)
    )
    Spacer(modifier = Modifier.size(16.dp))
    PrimaryButton(text = "Log in") { navController?.navigate("home") }
}

@Composable
private fun ThisTextField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) = OutlinedTextField(
    value = value,
    placeholder = { Text(text = placeholder, style = MaterialTheme.typography.body1) },
    onValueChange = onValueChange,
    modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(horizontal = screenPadding)
)

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenPreview() = BloomApp {
    LoginScreen()
}
