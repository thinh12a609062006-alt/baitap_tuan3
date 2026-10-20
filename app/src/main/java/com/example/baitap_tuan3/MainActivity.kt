package com.example.baitap_tuan3

import android.R.attr.fontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.foundation.clickable
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.ui.text.input.PasswordVisualTransformation
import kotlin.math.roundToInt
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


private val BlueMain = Color(0xFF2196F3)
private val BlueCard = Color(0xFFBBDEFB)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    AppNavigation()
                }
            }
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(onReady = { navController.navigate("components") })
        }
        composable("components") {
            ComponentsListScreen(onTextClick = { navController.navigate("text_Detaill") },
                onImageClick = { navController.navigate("image_detail") },
                onTextFieldClick = { navController.navigate("text_field") },
                onRowClick = { navController.navigate("row_layout") },
                onColumnClick = { navController.navigate("column_layout") },
                onToggleClick = { navController.navigate("toggle") },
                onSliderClick = { navController.navigate("slider") },
                onDatePickerClick = { navController.navigate("date_picker")},
                onButtonClick = { navController.navigate("button") },
                onCheckboxClick = { navController.navigate("checkbox") },
                onRadioButtonClick = { navController.navigate("radio_button") },
                onPasswordFieldClick = { navController.navigate("password_field") },
                onPickerClick = { navController.navigate("picker") },
                onNavigtionClick = { navController.navigate("navigation") },
                onTabBarClick = { navController.navigate("tab_bar") },
                onMenuClick = { navController.navigate("menu") }
                )

        }
        composable("text_Detaill") {
            TextDetailScreen(pnBack = { navController.popBackStack() })
        }
        composable("image_detail") {
            ImagesScreen(onBack = { navController.popBackStack() })
        }
        composable("text_field") {
            TextFieldScreen(onBack = { navController.popBackStack() })
        }
        composable("row_layout") {
            RowLayoutScreen(onBack = { navController.popBackStack() })
            }
        composable("column_layout") {
            ColumnLayoutScreen(onBack = { navController.popBackStack() })
        }
        composable("toggle") {
            ToggleScreen(onBack = { navController.popBackStack() })
        }
        composable("slider") {
            SliderScreen(onBack = { navController.popBackStack() })
        }
        composable("date_picker") {
            DatePickerScreen(onBack = { navController.popBackStack() })
        }
        composable("button") {
            ButtonScreen(onBack = { navController.popBackStack() })
        }
        composable("checkbox") {
            CheckboxScreen(onBack = { navController.popBackStack() })
        }
        composable("radio_button") {
            RadioButtonScreen(onBack = { navController.popBackStack() })
        }
        composable("password_field") {
            PasswordFieldScreen(onBackClick = { navController.popBackStack() })
        }
        composable("picker") {
            PickerScreen(onBack = { navController.popBackStack() })
        }
        composable("navigation") {
            NavigationScreen(onBack = { navController.popBackStack() })
        }
        composable("tab_bar") {
            TabBarScreen(onBack = { navController.popBackStack() })
        }
        composable("menu") {
            MenuScreen(onBack = { navController.popBackStack() })
        }
    }
}

@Composable
fun WelcomeScreen(onReady: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.compose_logo),
            contentDescription = "Compose logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Jetpack Compose is a modern UI toolkit for\n" +
                    "building native Android applications using\n" +
                    "a declarative programming approach.",
            fontSize = 12.sp,
            lineHeight = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onReady,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BlueMain,
                contentColor = Color.White
            )
        ) {
            Text(text = "I'm ready", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}
@Composable
fun ComponentsListScreen(onTextClick: () -> Unit = {},
                         onImageClick: () -> Unit = {},
                         onTextFieldClick: () -> Unit = {},
                         onRowClick: () -> Unit = {},
                         onColumnClick: () -> Unit = {},
                         onToggleClick: () -> Unit = {},
                         onSliderClick: () -> Unit = {},
                         onDatePickerClick: () -> Unit = {},
                         onButtonClick: () -> Unit = {},
                         onCheckboxClick: () -> Unit = {},
                         onRadioButtonClick: () -> Unit = {},
                         onPasswordFieldClick: () -> Unit = {},
                         onPickerClick: () -> Unit = {},
                         onNavigtionClick: () -> Unit = {},
                         onTabBarClick: () -> Unit = {},
                         onMenuClick: () -> Unit = {},){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = " UI Components List",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = BlueMain
        )
        Spacer(modifier = Modifier.height(16.dp))
        SectionHeader(title =" Display ")
        ComponentCard(
            title = "Text",
            description =" Display text",
            onClick = onTextClick
        )
        ComponentCard(
            title = " Image",
            description =" Display an image",
            onClick = onImageClick
        )
        SectionHeader(title =" Input ")
        ComponentCard(
            title = "TextField",
            description =" imput field for text",
            onClick = onTextFieldClick
        )
        ComponentCard(
            title = "PasswordField",
            description =" imput field for passwords",
            onClick = onPasswordFieldClick
        )

        SectionHeader(title =" Layout ")
        ComponentCard(
            title = "Column",
            description =" Arranges elements vertically",
            onClick = onColumnClick
        )
        ComponentCard(
            title = "Row",
            description =" Arranges elements horizontally",
            onClick = onRowClick
        )
        ComponentCard(
            title = "Toggle",
            description ="On/off switch",
            onClick = onToggleClick
        )
        ComponentCard(
            title = "Slider",
            description ="Selects a value from a range",
            onClick = onSliderClick
        )
        ComponentCard(
            title = "DatePicker",
            description ="Selects a date and time",
            onClick = onDatePickerClick
        )
        SectionHeader(title ="Selection")
        ComponentCard(
            title = "Button",
            description ="Triggers an action when clicked",
            onClick = onButtonClick
        )
        ComponentCard(
            title = "Checkbox",
            description ="Selects one or multiple options",
            onClick = onCheckboxClick
        )
        ComponentCard(
            title = "RadioButton",
            description ="Selects a single option",
            onClick = onRadioButtonClick
        )
        ComponentCard(
            title = "Picker",
            description ="Selects a value from a list",
            onClick = onPickerClick
        )
        SectionHeader(title ="Navigation")
        ComponentCard(
            title = "NavigationView",
            description ="Navigation container with title and back button",
            onClick = onNavigtionClick
        )
        ComponentCard(
            title = "TabBar",
            description ="Switches between main sections",
            onClick = onTabBarClick
        )
        ComponentCard(
            title = "Menu",
            description ="Shows a menu with multiple actions",
            onClick = onMenuClick
        )
        SectionHeader(title ="Content")
        ComponentCard(
            title= "List",
            description="Displays a list of items",
            onClick= onTextClick
        )
        ComponentCard(
            title= "Card",
            description="Container with content and style",
            onClick= onTextClick
        )
        ComponentCard(
            title= "Divider",
            description="Separates content into sections",
            onClick= onTextClick
        )
    }
}
@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun ComponentCard(
    title: String,
    description: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = BlueCard)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Text(
                text = description,
                style = TextStyle(fontSize = 13.sp, color = Color.Gray)
            )
        }
    }
}
@Composable
fun TextDetailScreen (pnBack:() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical=16.dp)
        ){
            IconButton(
                onClick = pnBack,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = BlueMain,
                )
            }
            Text(
                text = "Text Detaill",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = BlueMain
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buildAnnotatedString{
                    append(" the ")
                    withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)){
                        append(" quick")
                    }
                    append("  ")
                    withStyle(SpanStyle(color = Color(0xFFC77700),fontSize=34.sp)){
                        append(" Brown")
                    }
                    append("\nfox ")
                    withStyle(SpanStyle(letterSpacing=6.sp)){
                        append(" jumps")
                    }
                    append(" ")
                    withStyle(SpanStyle(fontWeight=FontWeight.Bold,fontStyle=FontStyle.Italic)){
                        append(" over ")
                    }
                    append("\n")
                    withStyle(SpanStyle(textDecoration = TextDecoration.Underline)){
                        append(" the ")
                    }
                    append(" ")
                    withStyle(SpanStyle(fontStyle= FontStyle.Italic,fontFamily=FontFamily.Cursive)){
                        append(" lazy")
                    }
                    append(" dog")
                },
                fontSize = 28.sp,
                lineHeight= 46.sp
            )
        }

    }
}
@Composable
fun DetailTopBar(title: String, onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = BlueMain
            )
        }
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = BlueMain
        )
    }
}
@Composable
fun ImagesScreen(onBack: () -> Unit) {
    val imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6T56Q7CVl5J8BQhskpquysH6sTtXJD1IHm8Ha0Z6vk0faUEA8wwdrwm4&s=10"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        DetailTopBar(title = "Images", onBack = onBack)
        Spacer(modifier = Modifier.height(16.dp))

        AsyncImage(
            model = imageUrl,
            contentDescription = "Ảnh từ internet",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFEEEEEE))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = imageUrl,
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.campus_image),
            contentDescription = "Ảnh trong app",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "In app",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Composable
fun TextFieldScreen(onBack: () -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 24.dp)
    ){
        DetailTopBar(title = "TextField", onBack = onBack)
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                value= text,
                onValueChange= { text = it },
                placeholder= {Text(text = "thông tin nhập", fontSize = 13.sp)},
                singleLine= true,
                shape= RoundedCornerShape(12.dp),
                modifier= Modifier.fillMaxWidth()
            )
            Spacer(modifier=Modifier.height(12.dp))
            Text(
                text= if (text.isEmpty())"tự động nhập dữ liệu theo textField " else text,
                    color=Color.Red,
                    fontSize=12.sp
            )
        }
    }
}
@Composable
fun PasswordFieldScreen(onBackClick: () -> Unit) {
    var passwordText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "<",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = BlueMain,
                modifier = Modifier
                    .clickable { onBackClick() }
                    .padding(8.dp)
            )
            Text(
                text = "PasswordField Detail",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = BlueMain
                )
            )
            Spacer(modifier = Modifier.width(32.dp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text("Nhập mật khẩu") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Giá trị thực: $passwordText",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
@Composable
fun RowLayoutScreen(onBack: () -> Unit) {
    val lightBlue = Color(0xFFA9C4F5)
    val darkBlue = Color(0xFF4A86E8)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)

    ){
        DetailTopBar(title = "Row Layout", onBack = onBack)
        Spacer(modifier = Modifier.height(16.dp))

        repeat(4){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF1F4FA))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(lightBlue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(darkBlue)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(lightBlue)
                )
            }
        }
    }
}
@Composable
fun ColumnLayoutScreen(onBack: () -> Unit) {
    val lightGreen = Color(0xFFB3E6C5)
    val darkGreen = Color(0xFF6FD68F)
    val borderColor = Color(0xFF1F3A4D)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "Column Layout", onBack = onBack)


        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .width(140.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = borderColor,
                            cornerRadius = CornerRadius(4.dp.toPx()),
                            style = Stroke(
                                width = 2.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(10.dp.toPx(), 6.dp.toPx())
                                )
                            )
                        )
                    }
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(lightGreen)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(darkGreen)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(lightGreen)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Column",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}
@Composable
fun ToggleScreen(onBack: () -> Unit) {
    var notifyOn by remember { mutableStateOf(false) }
    var wifiOn by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "Toggle", onBack = onBack)
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Thông báo", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Switch(
                checked = notifyOn,
                onCheckedChange = { notifyOn = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = if (notifyOn) "Thông báo đang BẬT" else "Thông báo đang TẮT",
            color = if (notifyOn) BlueMain else Color.Gray,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Wi-Fi", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Switch(
                checked = wifiOn,
                onCheckedChange = { wifiOn = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF4CAF50),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFFBDBDBD)
                )
            )
        }
    }
}
@Composable
fun SliderScreen(onBack: () -> Unit) {
    var volume by remember { mutableStateOf(50f) }
    var rating by remember { mutableStateOf(3f) }
    var brightness by remember { mutableStateOf(0.7f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "Slider", onBack = onBack)
        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Âm lượng", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(text = "${volume.roundToInt()}", fontSize = 16.sp, color = BlueMain)
            }
            Slider(
                value = volume,
                onValueChange = { volume = it },
                valueRange = 0f..100f
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Đánh giá", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(text = "${rating.roundToInt()} / 5 sao", fontSize = 16.sp, color = BlueMain)
            }
            Slider(
                value = rating,
                onValueChange = { rating = it },
                valueRange = 1f..5f,
                steps = 3
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Độ sáng", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(text = "${(brightness * 100).roundToInt()}%", fontSize = 16.sp, color = Color(0xFFFB8C00))
            }
            Slider(
                value = brightness,
                onValueChange = { brightness = it },
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFFB8C00),
                    activeTrackColor = Color(0xFFFB8C00),
                    inactiveTrackColor = Color(0xFFFFE0B2)
                )
            )
        }
    }
}
// Đổi số mili giây thành chữ "dd/MM/yyyy"
fun formatDate(millis: Long): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    return sdf.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen(onBack: () -> Unit) {

    var showDateDialog by remember { mutableStateOf(false) }
    var showTimeDialog by remember { mutableStateOf(false) }


    var selectedDate by remember { mutableStateOf("Chưa chọn ngày") }
    var selectedTime by remember { mutableStateOf("Chưa chọn giờ") }


    val dateState = rememberDatePickerState()
    val timeState = rememberTimePickerState(
        initialHour = 8,
        initialMinute = 0,
        is24Hour = true
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "DatePicker", onBack = onBack)
        Spacer(modifier = Modifier.height(24.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Ngày", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(selectedDate, fontSize = 16.sp, color = BlueMain)
            }
            Button(onClick = { showDateDialog = true }) {
                Text("Chọn ngày")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BlueCard)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Giờ", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(selectedTime, fontSize = 16.sp, color = BlueMain)
            }
            Button(onClick = { showTimeDialog = true }) {
                Text("Chọn giờ")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Bạn chọn: $selectedDate lúc $selectedTime",
            color = Color.Red,
            fontSize = 13.sp
        )
    }

    if (showDateDialog) {
        DatePickerDialog(
            onDismissRequest = { showDateDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    dateState.selectedDateMillis?.let { selectedDate = formatDate(it) }
                    showDateDialog = false
                }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { showDateDialog = false }) { Text("Hủy") }
            }
        ) {
            DatePicker(state = dateState)
        }
    }

    if (showTimeDialog) {
        AlertDialog(
            onDismissRequest = { showTimeDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    selectedTime = String.format(
                        Locale.getDefault(), "%02d:%02d", timeState.hour, timeState.minute
                    )
                    showTimeDialog = false
                }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { showTimeDialog = false }) { Text("Hủy") }
            },
            text = { TimePicker(state = timeState) }
        )
    }
}
@Composable
fun ButtonScreen(onBack: () -> Unit) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "Button", onBack = onBack)

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Bạn đã bấm: $count lần", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { count++ }) {
                Text("Bấm vào đây")
            }
            Button(onClick = { count = 0 }) { Text("Đặt lại") }
        }
    }
}
@Composable
fun CheckboxScreen(onBack: () -> Unit) {
    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "Checkbox", onBack = onBack)

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
                Text("Tôi Đã chọn ", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = if (checked) "Bạn đã tick" else "Bạn chưa tick",
                color = Color.Red,
                fontSize = 14.sp
            )
        }
    }
}
@Composable
fun RadioButtonScreen(onBack: () -> Unit) {
    val options = listOf("Nam", "Nữ", "Khác")
    var selected by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "RadioButton", onBack = onBack)

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Chọn giới tính", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))

            options.forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selected == option,
                        onClick = { selected = option }
                    )
                    Text(option, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Bạn đã chọn: $selected",
                color = Color.Red,
                fontSize = 14.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickerScreen(onBack: () -> Unit) {
    val danhSach = listOf("Táo", "Cam", "Chuối", "Xoài")
    var moMenu by remember { mutableStateOf(false) }
    var chonTrai by remember { mutableStateOf(danhSach[0]) }
    val mauXanh = Color(0xFF2E86DE)

    Scaffold(
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Picker",
                        color = mauXanh,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = mauXanh
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Chọn trái cây",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = moMenu,
                onExpandedChange = { moMenu = !moMenu },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                OutlinedTextField(
                    value = chonTrai,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = moMenu)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = moMenu,
                    onDismissRequest = { moMenu = false }
                ) {
                    danhSach.forEach { trai ->
                        DropdownMenuItem(
                            text = { Text(trai) },
                            onClick = {
                                chonTrai = trai
                                moMenu = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Bạn đã chọn: $chonTrai",
                color = Color(0xFFC62828)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Tiêu đề màn hình", color = BlueMain) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = BlueMain
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Đây là nội dung của màn hình", fontSize = 16.sp)
        }
    }
}
@Composable
fun TabBarScreen(onBack: () -> Unit) {
    val titles = listOf("Home", "Search", "Profile")
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
    ) {
        DetailTopBar(title = "TabBar", onBack = onBack)

        TabRow(selectedTabIndex = selectedTab) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text("Bạn đang ở tab: ${titles[selectedTab]}", fontSize = 18.sp)
        }
    }
}
@Composable
fun MenuScreen(onBack: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("Chưa chọn hành động nào") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar(title = "Menu", onBack = onBack)

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Button(onClick = { expanded = true }) {
                    Text("Mở menu")
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Chia sẻ") },
                        onClick = { result = "Bạn chọn: Chia sẻ"; expanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text("Chỉnh sửa") },
                        onClick = { result = "Bạn chọn: Chỉnh sửa"; expanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text("Xóa") },
                        onClick = { result = "Bạn chọn: Xóa"; expanded = false }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(result, color = Color.Red, fontSize = 14.sp)
        }
    }
}