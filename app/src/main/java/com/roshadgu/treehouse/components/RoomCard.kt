package com.roshadgu.treehouse.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roshadgu.treehouse.ui.theme.nunito_fonts
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.ComposeCompilerApi
import com.roshadgu.treehouse.R
import com.roshadgu.treehouse.ui.theme.gray700
import kotlin.random.Random

@Composable
fun RoomCard(room: Room)
{
    Box(
        modifier = Modifier
            .width(343.dp)
            .height(196.dp)
            .padding(10.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(Color(red = 0.9960784316062927f, green = 1f, blue = 1f, alpha = 1f))
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Image(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(60.dp),
                painter = painterResource(id = room.imageRes),
                contentDescription = "PFP of speaker or speakers"
            )
            Column(modifier = Modifier.padding(start = 30.dp, top = 10.dp))
            {
                Text(room.room_title, fontWeight = FontWeight.Bold, fontFamily = nunito_fonts)

                //List of names
                userList()

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Text(room.num_listeners.toString(), Modifier.padding(end = 3.dp))
                    Image(painter = painterResource(id = R.drawable.user_icon), contentDescription = "Listeners", Modifier.size(13.dp))                    //slash
                    Text("/", Modifier.padding(start = 8.dp, end = 5.dp))
                    Text(room.num_speakers.toString(), Modifier.padding(end = 3.dp))
                    Image(painter = painterResource(id = R.drawable.chat_gray_icon), contentDescription = "Speakers", Modifier.size(13.dp))
                }
            }
        }
    }
}

@Composable
fun userList()
{
    var numOfParticipants = Random.nextInt(from = 1, until = 5)
    var randomUser = users.random()

    LazyColumn {
        items(numOfParticipants) {
            index -> Text(text = randomUser)
        }
    }
}

@Preview
@Composable
fun Preview()
{
    val room_1 = Room(2, "Talking how to design ClubHouse in your Figma", "I don't know", 126, 26, 5)
    RoomCard(room_1)
}