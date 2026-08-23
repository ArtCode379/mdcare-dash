package mdcosmetics.cosmetics.mdcaredash.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import mdcosmetics.cosmetics.mdcaredash.R

private val FontProvider =
    GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs,
    )

private val Heading =
    FontFamily(
        Font(
            googleFont = GoogleFont("Cormorant Garamond"),
            fontProvider = FontProvider,
            weight = FontWeight.SemiBold,
        )
    )

private val Body =
    FontFamily(
        Font(
            googleFont = GoogleFont("Montserrat"),
            fontProvider = FontProvider,
            weight = FontWeight.Normal,
        ),
        Font(
            googleFont = GoogleFont("Montserrat"),
            fontProvider = FontProvider,
            weight = FontWeight.SemiBold,
        ),
    )
val AppTypography =
    Typography(
        displaySmall =
            TextStyle(fontFamily = Heading, fontWeight = FontWeight.SemiBold, fontSize = 36.sp),
        headlineLarge =
            TextStyle(fontFamily = Heading, fontWeight = FontWeight.SemiBold, fontSize = 30.sp),
        headlineMedium =
            TextStyle(fontFamily = Heading, fontWeight = FontWeight.SemiBold, fontSize = 26.sp),
        titleLarge =
            TextStyle(fontFamily = Heading, fontWeight = FontWeight.SemiBold, fontSize = 22.sp),
        titleMedium =
            TextStyle(fontFamily = Body, fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
        bodyLarge =
            TextStyle(
                fontFamily = Body,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp),
        bodyMedium =
            TextStyle(
                fontFamily = Body,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 21.sp),
        labelLarge =
            TextStyle(fontFamily = Body, fontWeight = FontWeight.SemiBold, fontSize = 14.sp))
val Typography = AppTypography
