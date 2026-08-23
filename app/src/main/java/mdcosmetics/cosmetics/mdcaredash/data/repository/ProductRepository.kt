package mdcosmetics.cosmetics.mdcaredash.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import mdcosmetics.cosmetics.mdcaredash.data.model.Product
import mdcosmetics.cosmetics.mdcaredash.data.model.ProductCategory

class ProductRepository {
  private val products =
      listOf(
          Product(
              1,
              "Rose Renewal Serum",
              "A silky niacinamide and rosehip serum that supports an even-looking, luminous complexion. Apply two or three drops after cleansing.",
              ProductCategory.SKINCARE,
              28.00,
              "https://images.unsplash.com/photo-1620916566398-39f1143ab7be?w=1200"),
          Product(
              2,
              "Cloud Cream Moisturiser",
              "A comforting daily moisturiser with squalane and ceramides to soften dry skin without a heavy finish.",
              ProductCategory.SKINCARE,
              24.50,
              "https://images.unsplash.com/photo-1556228578-8c89e6adf883?w=1200"),
          Product(
              3,
              "Vitamin Glow Cleanser",
              "A gentle gel cleanser that lifts makeup and daily impurities while leaving skin fresh and comfortable.",
              ProductCategory.SKINCARE,
              16.00,
              "https://images.unsplash.com/photo-1556229010-6c3f2c9ca5f8?w=1200"),
          Product(
              4,
              "Botanical Body Oil",
              "Lightweight botanical oils nourish the body and leave a subtle spa-inspired fragrance.",
              ProductCategory.BODY,
              22.00,
              "https://images.unsplash.com/photo-1608571423902-eed4a5ad8108?w=1200"),
          Product(
              5,
              "Shea Silk Body Butter",
              "Rich shea and cocoa butters melt into dry areas for long-lasting softness.",
              ProductCategory.BODY,
              19.50,
              "https://images.unsplash.com/photo-1608248597279-f99d160bfcbc?w=1200"),
          Product(
              6,
              "Strength & Shine Shampoo",
              "A sulphate-free cleanse with panthenol and plant proteins for smooth, glossy hair.",
              ProductCategory.HAIR,
              18.00,
              "https://images.unsplash.com/photo-1535585209827-a15fcdbc4c2d?w=1200"),
          Product(
              7,
              "Nourishing Hair Mask",
              "A weekly moisture treatment designed to soften lengths and make detangling easier.",
              ProductCategory.HAIR,
              21.00,
              "https://images.unsplash.com/photo-1526947425960-945c6e72858f?w=1200"),
          Product(
              8,
              "Velvet Lip Tint",
              "Buildable, comfortable colour with a softly blurred satin finish for everyday wear.",
              ProductCategory.MAKEUP,
              14.00,
              "https://images.unsplash.com/photo-1586495777744-4413f21062fa?w=1200"),
          Product(
              9,
              "Radiance Face Palette",
              "A versatile trio of blush, bronzer and highlighter shades with a finely milled texture.",
              ProductCategory.MAKEUP,
              27.00,
              "https://images.unsplash.com/photo-1596704017254-975bd26e0d9f?w=1200"),
          Product(
              10,
              "Calm Ritual Bath Salts",
              "Mineral-rich bath salts scented with lavender and eucalyptus for an unhurried evening ritual.",
              ProductCategory.WELLNESS,
              15.50,
              "https://images.unsplash.com/photo-1600857544200-b2f666a9a2ec?w=1200"),
          Product(
              11,
              "Jade Facial Roller",
              "A cooling facial massage tool made for a soothing morning or evening skincare ritual.",
              ProductCategory.WELLNESS,
              17.00,
              "https://images.unsplash.com/photo-1616394584738-fc6e612e71b9?w=1200"),
          Product(
              12,
              "Daily Mineral SPF 30",
              "A sheer mineral sunscreen with a comfortable satin finish for everyday protection.",
              ProductCategory.SKINCARE,
              26.00,
              "https://images.unsplash.com/photo-1571781926291-c477ebfd024b?w=1200"))

  fun observeById(id: Int): Flow<Product?> = flowOf(products.find { it.id == id })

  fun getById(id: Int): Product? = products.find { it.id == id }

  fun observeAll(): Flow<List<Product>> = flowOf(products)
}
