package com.roshadgu.treehouse.components

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roshadgu.treehouse.R
import com.roshadgu.treehouse.ui.theme.TreehouseTheme
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import com.roshadgu.treehouse.model.rooms

class HomeActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContent {
      TreehouseTheme {
        homeScreen()
      }
    }
  }
}

@Composable
fun homeScreen()
{
  Surface(color = MaterialTheme.colors.surface){}

  ConstraintLayout(modifier = Modifier.fillMaxSize())
  {
    val(searchButton, invitesButton, calendarButton, notificationButton, profileButton) = createRefs()

    //Search Icon
    IconButton(
      onClick = { /* doSomething() */ },
      modifier = Modifier
        .constrainAs(searchButton)
        {
          top.linkTo(parent.top, margin = 25.dp)
          bottom.linkTo(parent.bottom, margin = 565.dp)
          start.linkTo(parent.start, margin = 5.dp)
          end.linkTo(invitesButton.start, margin = 10.dp)
        })
    {
      Image(
        painter = painterResource(id = R.drawable.search_icon),
        contentDescription = "search icon",
        modifier = Modifier
          .height(27.dp)
          .width(27.dp),
      )
    }

    //Invites Icon
    IconButton(
      onClick = { /* doSomething() */ },
      modifier = Modifier
        .constrainAs(invitesButton)
        {
          top.linkTo(parent.top, 25.dp)
          start.linkTo(searchButton.end, 68.dp)
          end.linkTo(calendarButton.start, 12.dp)
        }) {
      Image(
        painter = painterResource(id = R.drawable.invites_icon),
        contentDescription = null,
        modifier = Modifier
          .height(35.dp)
          .width(35.dp)
          .fillMaxSize(),
        contentScale = ContentScale.FillBounds
      )
    }

    //Calendar Icon
    IconButton(onClick = { /* doSomething() */ },
      modifier = Modifier
        .constrainAs(calendarButton)
        {
          top.linkTo(parent.top, 25.dp)
          start.linkTo(invitesButton.end)
          end.linkTo(notificationButton.end, 12.dp)
        })
    {
      Image(
        painter = painterResource(id = R.drawable.calendar_icon),
        contentDescription = null,
        modifier = Modifier
          .height(27.dp)
          .width(27.dp)
          .fillMaxSize(),
        contentScale = ContentScale.FillBounds
      )
    }

    //Notification Icon
    IconButton(onClick = { /* doSomething() */ },
      modifier = Modifier
        .constrainAs(notificationButton)
        {
          top.linkTo(parent.top, 25.dp)
          start.linkTo(calendarButton.end)
          end.linkTo(profileButton.start)
        })
    {
      Image(
        painter = painterResource(id = R.drawable.notification_icon),
        contentDescription = null,
        modifier = Modifier
          .height(35.dp)
          .width(35.dp)
          .fillMaxSize(),
        contentScale = ContentScale.FillBounds
      )
    }

    //Profile Icon
    IconButton(
      onClick = { /* doSomething() */ },
      modifier = Modifier
        .constrainAs(profileButton)
        {
          top.linkTo(parent.top, 25.dp)
          start.linkTo(calendarButton.end)
          end.linkTo(parent.end)
        }
    ) {
      Image(
        painter = painterResource(id = R.drawable.profile_rectangle),
        contentDescription = null,
        modifier = Modifier
          .height(27.dp)
          .width(27.dp),
        contentScale = ContentScale.FillBounds
      )
    }
  }
  //EventCell()
  RoomList(rooms)
}

@Composable
fun RoomList(rooms: List<Room>)
{
  val scrollState = rememberLazyListState()

  LazyColumn(
    modifier = Modifier.padding(top = 100.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
    state = scrollState) {
    items(rooms)
    {
      room -> RoomCard(room)
    }
  }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview()
{
  TreehouseTheme()
  {
    homeScreen()
  }
}