package com.seogaemo.shopping.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seogaemo.domain.model.Category
import com.seogaemo.domain.model.Price
import com.seogaemo.domain.model.Product
import com.seogaemo.domain.model.SalesStatus.*
import com.seogaemo.domain.model.Shop
import com.seogaemo.presentation.R

@Composable
fun ProductCard(product: Product, onClick: (Product) -> Unit?) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(10.dp)
            .shadow(elevation = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.product),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
            Text(fontSize = 14.sp, fontWeight = FontWeight.SemiBold, text = product.shop.shopName)
            Text(fontSize = 14.sp, fontWeight = FontWeight.SemiBold, text = product.productName)
            Price(product = product)
        }
    }
}

@Composable
private fun Price(product: Product) {
    when(product.price.salesStatus) {
        ON_SALE -> {
            Text(text = "${product.price.originPrice}", fontSize = 14.sp, style = TextStyle(textDecoration = TextDecoration.LineThrough))
            Row {
                Text(text = "할인가: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "${product.price.finalPrice}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
        NORMAL -> {
            Text(text = "${product.price.originPrice}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        SOLD_OUT -> {
            Text(text = "판매종료", fontSize = 18.sp, color = Color(0xFF666666))
        }
    }
}

@Preview
@Composable
private fun PreviewProductCard() {
    val product = Product(
        productId = "1",
        productName = "상품 이름",
        imageUrl = "",
        price = Price(3000, 300, ON_SALE),
        category = Category.Top,
        shop = Shop("1","샵 이름", ""),
        isNew = false,
        isFreeShipping = false,
    )
    ProductCard(product = product) {}
}

@Preview
@Composable
private fun PreviewProductCardNormal() {
    val product = Product(
        productId = "1",
        productName = "상품 이름",
        imageUrl = "",
        price = Price(3000, 300, NORMAL),
        category = Category.Top,
        shop = Shop("1","샵 이름", ""),
        isNew = false,
        isFreeShipping = false,
    )
    ProductCard(product = product) {}
}

@Preview
@Composable
private fun PreviewProductCardSoldOut() {
    val product = Product(
        productId = "1",
        productName = "상품 이름",
        imageUrl = "",
        price = Price(3000, 300, SOLD_OUT),
        category = Category.Top,
        shop = Shop("1","샵 이름", ""),
        isNew = false,
        isFreeShipping = false,
    )
    ProductCard(product = product) {}
}