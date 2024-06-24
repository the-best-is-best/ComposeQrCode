<h1 align="center">Compose Quill</h1><br>
<div align="center">
<a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
<a href="https://android-arsenal.com/api?level=21" rel="nofollow"><img alt="API" src="https://camo.githubusercontent.com/0eda703da08220e08354f624a3fc0023f10416a302565c69c3759bf6e0800d40/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4150492d32312532422d627269676874677265656e2e7376673f7374796c653d666c6174" data-canonical-src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" style="max-width: 100%;"></a>
<a href="https://github.com/the-best-is-best/"><img alt="Profile" src="https://img.shields.io/badge/github-.svg?&style=for-the-badge&logo=github&logoColor=white" height="20"/></a>
<a href="https://central.sonatype.com/search?q=io.github.the-best-is-best&smo=true"><img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.the-best-is-best/compose_qr_code"/></a>
<a href= "https://cocoapods.org/pods/TQrCode">
 <img src="https://img.shields.io/cocoapods/v/TQrCode.svg?style=flat" />
 </a>
<a href="https://github.com/the-best-is-best/TQrCode"> 
  <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="20" height="20"/>
</a>
</div>

A Compose library that provides to add Qr generator and qr reader.

## Download

[![Maven Central](https://img.shields.io/maven-central/v/io.github.the-best-is-best/compose_qr_code)](https://central.sonatype.com/artifact/io.github.the-best-is-best/compose_qr_code)

Compose QrCode is available on `mavenCentral()`.

```kotlin
implementation("io.github.the-best-is-best:compose_qr_code:1.0.0")
```

## How to use

### for reader

```kotlin


var code by remember { mutableStateOf("") }

Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Box(Modifier.height(520.dp)) {
            ReadQrCode(
                onQrCodeDetected = { qrCode ->
                    code = qrCode
                }
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "Code: $code")
    }

}
```

### for generator

```kotlin

QRCodeGenerator(content = "121", logo = R.drawable.logo_qr)

```

- Note not recommended to use the generator with logo because it will make the qr code not readable