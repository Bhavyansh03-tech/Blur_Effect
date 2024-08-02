# Blur Animation Sample

This project demonstrates a simple blur animation effect in Jetpack Compose using the `animateDpAsState` function. The screen contains a text element and an elevated card that apply a blur effect when toggled by a switch.

## Features

- Blur Animation: Animated blur effect on text and card elements.
- Elevated Card: A card that navigates to a second screen on click.
- Switch Toggle: A switch to toggle the blur effect.

## Libraries Used

- Jetpack Compose: Modern toolkit for building native Android UI.
- Material 3: Material Design 3 components and theming.
- Navigation: Jetpack Navigation component for handling navigation between screens.

## Screenshots

### Text And Card :
<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/user-attachments/assets/9434206f-5292-406c-9134-509f452931b2" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/38509a5d-e9fc-4deb-bb17-a9d3205d9105" alt="Second Screenshot" style="width: 200px; height: auto;">
</div>

### Image :
<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/user-attachments/assets/256029ab-27df-4368-93e0-87a8e7adbc00" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/9467a795-3f30-477e-84ae-7e4fc7d3e55c" alt="Second Screenshot" style="width: 200px; height: auto;">
</div>

## Getting Started

### Installation

1. Clone the repository:

   ```sh
     git clone https://github.com/Bhavyansh03-tech/Blur_Effect.git
   ```
   
2. Open the project in Android Studio.
3. Build the project and run it on an emulator or a physical device.

## Code Overview

### Text and Card

```kotlin
@Composable
fun MainScreen(
    navController: NavController
) {
    val checked by remember { mutableStateOf(true) }
    val animatedBlur by animateDpAsState(targetValue = if (checked) 10.dp else 0.dp, label = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A18)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.blur(
                radius = animatedBlur,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
            text = "Blur Effect",
            color = Color.White,
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        )
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.2f)
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(20.dp))
                    .size(150.dp)
                    .blur(
                        radius = animatedBlur,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    ),
                elevation = CardDefaults.cardElevation(16.dp),
                onClick = {
                    navController.navigate("SecondScreen")
                }
            ) {
                Image(
                    modifier = Modifier.height(200.dp),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Switch(checked = checked, onCheckedChange = { !checked })
    }
}
```

### Image

```kotlin
@Composable
fun SecondScreen() {

    val isBlurred = remember { mutableStateOf(false) }
    val animatedBlur by animateDpAsState(targetValue = if (isBlurred.value) 10.dp else 0.dp, label = "...")
    val scrollState = rememberScrollState()

    val imageList = listOf(
        R.drawable.img,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img4,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        imageList.forEach { imageResId ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .blur(
                        radius = animatedBlur,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
                    .clickable {
                        isBlurred != isBlurred
                    },
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).

---
