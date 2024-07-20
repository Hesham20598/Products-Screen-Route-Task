package com.hesham.productsscreenroutetask.utils

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hesham.domain.entity.ProductItemDTO
import com.hesham.productsscreenroutetask.R
import com.hesham.productsscreenroutetask.ui.theme.blueColor
import com.hesham.productsscreenroutetask.ui.theme.goldColor
import com.hesham.productsscreenroutetask.ui.theme.grayColor
import com.hesham.productsscreenroutetask.ui.theme.itemTextColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemProduct(
    productItem: ProductItemDTO,
    index: Int,
    onProductItemClick: () -> Unit,
    onAddToWishListClick: () -> Unit,
    addedToWishList: Boolean = false,
    onAddIconClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = if (index % 2 == 0) {
            Modifier
                .padding(start = 16.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(237.dp)
                .clickable {
                    onProductItemClick()
                }
                .border(shape = RoundedCornerShape(15.dp), width = 2.dp, color = grayColor)
        } else {
            Modifier
                .padding(start = 8.dp, end = 16.dp, bottom = 16.dp)
                .height(237.dp)
                .fillMaxWidth()
                .clickable {
                    onProductItemClick()
                }
                .border(shape = RoundedCornerShape(15.dp), width = 2.dp, color = grayColor)
        }

    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f)
        ) {
            val (productImage, addToWishlistIcon) = createRefs()

            GlideImage(
                model = productItem.thumbnail,
                contentDescription = stringResource(id = R.string.product_image),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .constrainAs(productImage) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentScale = ContentScale.Crop
            )
            AddToWishlistIcon(
                addedToWishList = addedToWishList,
                modifier = Modifier.constrainAs(addToWishlistIcon) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
            ) {
                onAddToWishListClick()
            }


        }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (name, description, price, discountPercentage, review, reviewValue, starIcon, addIcon) = createRefs()
                // name
                Text(
                    text = productItem.title ?: "", style = TextStyle(
                        fontSize = 14.sp,
                        color = itemTextColor,
                    ), maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.constrainAs(name) {
                        top.linkTo(parent.top, margin = 4.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                        width = Dimension.fillToConstraints
                    }
                )
                // description
                Text(
                    text = productItem.description ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = itemTextColor
                    ),
                    modifier = Modifier.constrainAs(description) {
                        top.linkTo(name.bottom, margin = 4.dp)
                        start.linkTo(name.start)
                        end.linkTo(parent.end, margin = 8.dp)
                        width = Dimension.fillToConstraints
                    }
                )
                //price
                Text(text = "${productItem.price}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = itemTextColor
                    ),
                    modifier = Modifier.constrainAs(price) {
                        top.linkTo(description.bottom, margin = 8.dp)
                        start.linkTo(name.start)
                        bottom.linkTo(review.top)
                    }
                )
                // discount percentage
                Text(
                    text = "${productItem.discountPercentage}",
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 11.sp,
                        color = blueColor
                    ),
                    modifier = Modifier.constrainAs(discountPercentage) {
                        top.linkTo(price.top)
                        start.linkTo(price.end, margin = 14.dp)
                        bottom.linkTo(price.bottom)
                    }

                )
                Text(text = "Review ", style = TextStyle(
                    fontSize = 12.sp,
                    color = itemTextColor
                ),
                    modifier = Modifier.constrainAs(review) {
                        top.linkTo(price.bottom, margin = 8.dp)
                        start.linkTo(price.start)
                        bottom.linkTo(parent.bottom)
                    }
                )
                // review
                Text(text = "${productItem.rating}", style = TextStyle(
                    fontSize = 12.sp,
                    color = itemTextColor
                ),
                    modifier = Modifier.constrainAs(reviewValue) {
                        top.linkTo(review.top)
                        start.linkTo(review.end, margin = 8.dp)
                        bottom.linkTo(review.bottom)
                    }
                )
                // star icon
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star icon",
                    tint = goldColor,
                    modifier = Modifier
                        .size(15.dp)
                        .constrainAs(starIcon) {
                            top.linkTo(review.top)
                            start.linkTo(reviewValue.end, margin = 4.dp)
                            bottom.linkTo(review.bottom)
                        }
                )
                // add icon
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add icon",
                    modifier = Modifier
                        .size(30.dp)
                        .constrainAs(addIcon) {
                            bottom.linkTo(parent.bottom, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                        }
                        .clickable {
                            onAddIconClick()
                            Log.e("TAG", "ProductItem: you clicked on add button ")
                        }

                )

            }
        }

    }
}