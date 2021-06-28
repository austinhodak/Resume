package com.austinhodak.resume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.austinhodak.resume.ui.theme.Pink500
import com.austinhodak.resume.ui.theme.ResumeTheme

@ExperimentalMaterialApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var state by remember { mutableStateOf(0) }
            val titles = listOf("Skills", "Projects", "Contact")
            ResumeTheme {
                Scaffold(
                    topBar = {
                        Card(
                            backgroundColor = MaterialTheme.colors.primary,
                            elevation = 5.dp,
                            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                        ) {
                            Column(
                                Modifier
                                    .background(color = MaterialTheme.colors.primary)
                                    .fillMaxWidth()
                            ) {
                                UserCard()
                                AnimatedVisibility(visible = state == 0) {
                                    Text(
                                        modifier = Modifier.padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            bottom = 16.dp
                                        ),
                                        text = "Self-taught Android Developer, specializing in Firebase. Proficient in Kotlin. Knowledge in Flutter/Dart, Java, Node.js. Learning new technologies such as Jetpack Compose!",
                                        style = MaterialTheme.typography.body2,
                                        color = Color.White
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .padding(
                                            start = 8.dp,
                                            end = 8.dp,
                                            bottom = 16.dp,
                                            top = 0.dp
                                        )
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    CircleButton(
                                        R.drawable.icons8_phone_96,
                                        "tel:+18146887657"
                                    )
                                    CircleButton(
                                        R.drawable.icons8_chat_bubble_96,
                                        "sms:+18146887657"
                                    )
                                    CircleButton(
                                        R.drawable.icons8_gmail_96,
                                        "mailto:ahodak65@gmail.com"
                                    )
                                    CircleButton(
                                        R.drawable.icons8_linkedin_circled_96,
                                        "https://www.linkedin.com/in/austin-h-823b66b2/"
                                    )
                                    CircleButton(
                                        R.drawable.icons8_github_96__1_,
                                        "https://github.com/austinhodak"
                                    )
                                    CircleButton(
                                        R.drawable.icons8_google_play_96,
                                        "https://play.google.com/store/apps/dev?id=8529450148277158654"
                                    )
                                    CircleButton(
                                        R.drawable.icons8_facebook_96,
                                        "https://www.facebook.com/austin.hodak/"
                                    )
                                }
                            }
                        }
                    },
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = if (isSystemInDarkTheme()) Color(0xFF212121) else Color(
                                0xFF2196F3
                            )
                        ) {
                            titles.forEachIndexed { index, item ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            painter = painterResource(
                                                id = when (index) {
                                                    0 -> R.drawable.icons8_project_management_96
                                                    1 -> R.drawable.icons8_project_96
                                                    2 -> R.drawable.icons8_cv_96
                                                    else -> R.drawable.icons8_chat_bubble_96
                                                }
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    },
                                    label = { Text(item) },
                                    selected = state == index,
                                    onClick = { state = index }
                                )
                            }
                        }
                    },
                    backgroundColor = MaterialTheme.colors.background
                ) { paddingValues ->
                    LazyColumn(
                        contentPadding = paddingValues
                    ) {
                        item {
                            Crossfade(targetState = state) {
                                when (it) {
                                    0 -> SkillsScreen()
                                    1 -> ProjectsScreen()
                                    2 -> ContactScreen()
                                    else -> SkillsScreen()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
private fun SkillsScreen() {
    Column(
        modifier = Modifier
            .padding(vertical = 4.dp),
    ) {
        SkillCard(
            "Firebase",
            "Advanced (5+ Years)",
            R.drawable.icons8_firebase_144,
            "I have been using Firebase since before Google acquired them. "
        )
        SkillCard(
            "Kotlin",
            "Advanced (3 Years)",
            R.drawable.icons8_kotlin_144,
            "I have been using Kotlin since Google announced it for Android back in 2017!"
        )
        SkillCard(
            "Jetpack Compose",
            "This app was built with compose!",
            R.drawable.jetpack_compose_icon_rgb,
            "Jetpack Compose is new and in beta, therefore everyone is still learning it!"
        )
        SkillCard(
            "Flutter",
            "Beginner (<1 Year)",
            R.drawable.icons8_flutter_144,
            "I've built an app with Flutter, however have not used it in quite a while."
        )
        SkillCard(
            "Java",
            "Advanced (5+ Years)",
            R.drawable.icons8_java_144,
            "I started learning Java when I was 13, I have since moved onto Kotlin as my main language!"
        )
        SkillCard(
            "Javascript",
            "Intermediate (3 Years)",
            R.drawable.icons8_javascript_96,
            "I use Javascript in my backend servers (Firebase Functions)."
        )
        SkillCard(
            "Node.js",
            "Intermediate (3 Years)",
            R.drawable.icons8_nodejs_144,
            "Same as Javascript, I use Node in my backend servers (Firebase Functions)."
        )
        SkillCard(
            "Git",
            "Intermediate (3 Years)",
            R.drawable.icons8_git_144,
            "Good knowledge of Git, used in all of my projects."
        )
        SkillCard(
            "Swift",
            "Beginner",
            R.drawable.icons8_swift_144,
            "Small amount of work with Swift in the past, would need to review and get up to date with new technologies."
        )
        SkillCard(
            "HTML/CSS",
            "Beginner",
            R.drawable.icons8_html_5_144,
            "Basic knowledge of HTMl/CSS fundamentals."
        )
    }
}

@Composable
private fun ProjectsScreen() {
    Column(
        modifier = Modifier
            .padding(vertical = 4.dp),
    ) {
        NewsStory(
            R.drawable.hideout_header,
            "The Hideout",
            "1,000+ Users (⭐ 4.16)",
            "Released 6 Months Ago",
            "Google Play",
            "https://play.google.com/store/apps/details?id=com.austinhodak.thehideout"
        )
        NewsStory(
            R.drawable.screenshot_1,
            "Battlegrounds Buddy",
            "Over 100,000 downloads when unpublished.",
            "Promoted by the PUBG Team.",
            "GITHUB",
            "https://github.com/austinhodak/BattleSTAT"
        )
        NewsStory(
            R.drawable.screenshot_20160914_224354,
            "Responding.io",
            "Response system for first responders and 911 centers.",
            "Only used internally.",
            "GITHUB",
            "https://github.com/austinhodak/respondingio-android"
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun ContactScreen() {
    Column(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = 2.dp,
        ) {
            Column(
                Modifier.padding(top = 16.dp, bottom = 4.dp)
            ) {
                Text(
                    text = "BASIC INFO",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                ListItem(
                    text = {
                        Text("Location")
                    },
                    secondaryText = {
                        Text("Erie, Pennsylvania, USA. Looking to work remotely.")
                    }
                )
                Divider(
                    modifier = Modifier.padding(top = 0.dp, end = 16.dp, start = 16.dp)
                )
                ListItem(
                    text = {
                        Text("Type of Work")
                    },
                    secondaryText = {
                        Text("Full time or contract work.")
                    }
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = 2.dp,
        ) {
            Column(
                Modifier.padding(vertical = 16.dp)
            ) {
                Text(
                    text = "WORK AUTHORIZATION",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                ListItem(
                    text = {
                        Text("Are you legally authorized to work in the United States?")
                    },
                    secondaryText = {
                        Text("Yes")
                    }
                )
                Divider(
                    modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 16.dp)
                )
                ListItem(
                    text = {
                        Text("Will you now, or in the future, require sponsorship for employment visa status?")
                    },
                    secondaryText = {
                        Text("No")
                    }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
private fun SkillCard(s: String, s1: String, icon: Int, desc: String = "") {
    var isExpanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(targetValue = if (isExpanded) 0F else -180F)

    Card(
        onClick = { isExpanded = !isExpanded },
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
    ) {
        Column(
            Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(36.dp),
                    tint = Color.Unspecified
                )
                Column(
                    Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = s,
                        style = MaterialTheme.typography.h6,
                        fontSize = 18.sp
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            text = s1,
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(
                        Icons.Filled.KeyboardArrowUp,
                        modifier = Modifier
                            .size(24.dp)
                            .rotate(rotationAngle),
                        contentDescription = null
                    )
                }

            }
            AnimatedVisibility(visible = isExpanded) {
                Column {
                    Divider(
                        modifier = Modifier.padding(top = 16.dp, end = 8.dp),
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp, end = 8.dp),
                        text = desc,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

@Composable
private fun CircleButton(
    icon: Int,
    link: String? = null
) {

    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(link ?: "")) }

    FloatingActionButton(
        onClick = { context.startActivity(intent) },
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .size(36.dp),
        backgroundColor = Color.White
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Localized description",
            modifier = Modifier.size(22.dp),
            tint = Color.Unspecified
        )
    }
}

@Composable
private fun UserCard() {
    val context = LocalContext.current
    val padding = 16.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = padding, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image003),
            contentDescription = null,
            modifier = Modifier
                .height(64.dp)
                .width(64.dp)
                .border(1.dp, color = Color.White, CircleShape)
                .clip(CircleShape)
        )
        Column(
            Modifier
                .padding(padding)
                .weight(1f)
        ) {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                Text(
                    text = "Austin Hodak",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )
            }
        }
        IconButton(onClick = {
            Toast
            .makeText(context, "Open to remote working.", Toast.LENGTH_SHORT)
            .show()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icons8_remote_working_96),
                contentDescription = "Open to remote working.",
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun UserCardPreview() {
    UserCard()
}

@Composable
fun Toolbar() {

    TopAppBar(
        title = { Text(text = "", color = MaterialTheme.colors.onPrimary) },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.icons8_linkedin_96),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.icons8_github_96),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        elevation = 0.dp
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    Toolbar()
}

@Preview("Toolbar Dark")
@Composable
fun ToolbarPreviewDark() {
    ResumeTheme(darkTheme = true) {
        Toolbar()
    }
}

@Composable
fun NewsStory(
    image: Int = R.drawable.icons8_nodejs_144,
    title: String,
    s1: String,
    s2: String,
    s3: String,
    s4: String
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(s4 ?: "")) }

    val typography = MaterialTheme.typography
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Spacer(Modifier.height(16.dp))

            Text(
                title,
                style = typography.h6
            )
            Text(
                s1,
                style = typography.body2
            )
            Text(
                s2,
                style = typography.body2
            )
            Button(
                onClick = { context.startActivity(intent) },
                Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(text = s3.toUpperCase())
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory(R.drawable.icons8_javascript_96, "The Hideout", "1", "2", "Button", "Link")
}