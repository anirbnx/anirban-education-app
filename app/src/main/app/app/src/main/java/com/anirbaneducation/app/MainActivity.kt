package com.anirbaneducation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class MenuItem(
    val title: String,
    val icon: String
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnirbanEducationApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnirbanEducationApp() {

    var selectedPage by remember {
        mutableStateOf("Home")
    }

    MaterialTheme {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {

                        Column {

                            Text(
                                text = "Anirban Education",
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "SSC & West Bengal State Exams",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                )
            },

            bottomBar = {

                NavigationBar {

                    NavigationBarItem(
                        selected = selectedPage == "Home",
                        onClick = {
                            selectedPage = "Home"
                        },
                        icon = {
                            Text("⌂")
                        },
                        label = {
                            Text("Home")
                        }
                    )

                    NavigationBarItem(
                        selected = selectedPage == "Courses",
                        onClick = {
                            selectedPage = "Courses"
                        },
                        icon = {
                            Text("📚")
                        },
                        label = {
                            Text("Courses")
                        }
                    )

                    NavigationBarItem(
                        selected = selectedPage == "Profile",
                        onClick = {
                            selectedPage = "Profile"
                        },
                        icon = {
                            Text("👤")
                        },
                        label = {
                            Text("Profile")
                        }
                    )
                }
            }

        ) { paddingValues ->

            when (selectedPage) {

                "Home" -> {
                    HomeScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }

                "Courses" -> {
                    SimplePage(
                        title = "Courses",
                        modifier = Modifier.padding(paddingValues)
                    )
                }

                "Profile" -> {
                    SimplePage(
                        title = "Profile",
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val menuItems = listOf(

        MenuItem(
            title = "SSC Exams",
            icon = "🇮🇳"
        ),

        MenuItem(
            title = "WB State Exams",
            icon = "🟢"
        ),

        MenuItem(
            title = "Courses",
            icon = "📚"
        ),

        MenuItem(
            title = "Study PDFs",
            icon = "📄"
        ),

        MenuItem(
            title = "Mock Tests",
            icon = "📝"
        ),

        MenuItem(
            title = "Exam Updates",
            icon = "🔔"
        )
    )


    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {

        Card(

            modifier = Modifier
                .fillMaxWidth(),

            colors = CardDefaults.cardColors(

                containerColor =
                    MaterialTheme.colorScheme.primaryContainer
            )

        ) {

            Column(

                modifier = Modifier
                    .padding(20.dp)

            ) {

                Text(

                    text = "Welcome to Anirban Education",

                    style =
                        MaterialTheme.typography.headlineSmall,

                    fontWeight =
                        FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text =
                        "Prepare smarter for SSC & West Bengal Government Exams."
                )
            }
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Text(

            text = "Explore",

            style =
                MaterialTheme.typography.titleLarge,

            fontWeight =
                FontWeight.Bold
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        LazyVerticalGrid(

            columns =
                GridCells.Fixed(2),

            verticalArrangement =
                Arrangement.spacedBy(12.dp),

            horizontalArrangement =
                Arrangement.spacedBy(12.dp),

            modifier =
                Modifier.fillMaxSize()

        ) {

            items(menuItems) { item ->

                Card(

                    onClick = {
                        // Future feature
                    },

                    modifier =
                        Modifier.height(130.dp)

                ) {

                    Column(

                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(16.dp),

                        verticalArrangement =
                            Arrangement.Center,

                        horizontalAlignment =
                            Alignment.CenterHorizontally

                    ) {

                        Text(

                            text = item.icon,

                            style =
                                MaterialTheme.typography.headlineMedium
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(

                            text = item.title,

                            fontWeight =
                                FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SimplePage(
    title: String,
    modifier: Modifier = Modifier
) {

    Box(

        modifier =
            modifier.fillMaxSize(),

        contentAlignment =
            Alignment.Center

    ) {

        Text(

            text = "$title section coming soon",

            style =
                MaterialTheme.typography.titleLarge,

            fontWeight =
                FontWeight.Bold
        )
    }
}
