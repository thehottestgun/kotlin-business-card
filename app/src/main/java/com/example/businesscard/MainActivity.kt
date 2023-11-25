package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray
                ) {
                    BusinessCardView(stringResource(id = R.string.business_card_name))
                }
            }
        }
    }
}

@Composable
fun BusinessCardView(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(200.dp, Alignment.Bottom)
    ) {
        NamePanel(name = name, modifier = modifier)
        ContactPanel(modifier = modifier)
    }
}

@Composable
fun NamePanel(name: String, modifier: Modifier = Modifier) {
    val picture = painterResource(id = R.drawable.cookie_monster)
    // Picture
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = picture,
            contentDescription = stringResource(R.string.cookie_monster_description),
        )
        // Name
        Text(
            text = name
        )
        // Title
        Text(
            text = stringResource(R.string.business_card_title)
        )
    }
}

@Composable
fun ContactPanel(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(
            imageName = R.drawable.call,
            imageDescription = stringResource(R.string.call_icon_description),
            contactText = stringResource(R.string.phone_number)
        )
        ContactRow(
            imageName = R.drawable.social,
            imageDescription = stringResource(R.string.social_icon_description),
            contactText = stringResource(R.string.social_handle)
        )
        ContactRow(
            imageName = R.drawable.mail,
            imageDescription = stringResource(R.string.mail_icon_description),
            contactText = stringResource(R.string.mail_address)
        )
    }
}

@Composable
fun ContactRow(
    imageName: Int?,
    imageDescription: String?,
    contactText: String?,
    modifier: Modifier = Modifier
) {
    val painterResource = painterResource(id = imageName ?: R.drawable.ic_launcher_foreground)
    Row(
        modifier = modifier.height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            painter = painterResource,
            contentDescription = imageDescription,
            tint = Color.Cyan,
            modifier = Modifier.size(30.dp)
        )
        Text(text = contactText ?: "placeholder")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardView(stringResource(id = R.string.business_card_name))
    }
}