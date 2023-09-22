package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recyclerview.ui.theme.RecyclerViewTheme
import com.example.recyclerview.utils.User
import com.example.recyclerview.utils.dummyData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
Recyclerview(user = dummyData() )
                }
            }
        }
    }

    @Composable
    fun EachRow(user: User) {
        Card(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            shape = RoundedCornerShape(CornerSize(10.dp)),

            ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.abhi),
                    contentDescription = "img",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(10.dp))
                        .size(80.dp)
                )
                Text(text = user.descripton, modifier = Modifier.padding(8.dp))
            }

        }

    }


    @Composable
    fun Recyclerview(user: List<User>) {
        LazyColumn {
            items(user) { user ->
                EachRow(user)
            }

        }
    }
}


