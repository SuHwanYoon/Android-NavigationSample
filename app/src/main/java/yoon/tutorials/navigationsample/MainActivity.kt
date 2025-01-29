package yoon.tutorials.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import yoon.tutorials.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp() {
    // NavController는 화면 간 이동을 관리하는 컴포넌트
    val navController = rememberNavController()
    // NavHost를 사용하여 화면을 구성
    // NavHost는 화면을 구성하는 컴포넌트로, NavHost 내부에 composable을 추가하여 화면을 구성
    // NavHost는 startDestination을 설정하여 시작 화면을 지정
    // NavHost는 rememberNavController를 사용하여 NavController를 생성
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable(route = "firstscreen") {
            // FirstScreen을 호출하여 화면을 구성
            // FirstScreen은 navigateToSecondScreen을 매개변수로 가짐
            FirstScreen(navigateToSecondScreen = {
                // navigate를 사용하여 화면 이동
                // navigate는 NavController를 사용하여 화면 간 이동을 처리
                // navigate의 인자로 이동할 화면의 route를 전달
                // route는 composable에 설정한 route를 전달
                navController.navigate("secondscreen")
            })
        }
        composable(route = "secondscreen") {
            SecondScreen( navigateToFirstScreen = {
                navController.navigate("firstscreen")
            })
        }
    }

}









