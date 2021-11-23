package com.roshadgu.treehouse.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
                //List on names
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Text(room.num_speakers.toString())
                    Text(room.num_listeners.toString())
                }

            }
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