package mdcosmetics.cosmetics.mdcaredash.data.model

import androidx.annotation.StringRes
import mdcosmetics.cosmetics.mdcaredash.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
  SKINCARE(R.string.gwbvb_category_skincare),
  BODY(R.string.gwbvb_category_body),
  HAIR(R.string.gwbvb_category_hair),
  MAKEUP(R.string.gwbvb_category_makeup),
  WELLNESS(R.string.gwbvb_category_wellness)
}
