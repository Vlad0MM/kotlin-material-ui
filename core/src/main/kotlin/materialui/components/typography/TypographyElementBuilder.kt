package materialui.components.typography

import kotlinext.js.jsObject
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import materialui.components.MaterialElementBuilder
import materialui.components.getValue
import materialui.components.setValue
import materialui.components.typography.enums.*
import materialui.styles.muitheme.MuiTheme
import react.RClass

open class TypographyElementBuilder<T: Tag, Props: TypographyProps> internal constructor(
    type: RClass<Props>,
    classMap: List<Pair<Enum<*>, String>>,
    factory: (TagConsumer<Unit>) -> T
) : MaterialElementBuilder<T, Props>(type, classMap, factory)  {
    fun Tag.classes(vararg classMap: Pair<TypographyStyle, String>) {
        classes(classMap.toList())
    }

    var Tag.align: TypographyAlign? by materialProps
    var Tag.color: TypographyColor? by materialProps
    var Tag.display: TypographyDisplay? by materialProps
    var Tag.gutterBottom: Boolean? by materialProps
    var Tag.variantMapping: VariantMapping? by materialProps
    var Tag.inline: Boolean? by materialProps
    var Tag.internalDeprecatedVariant: Boolean? by materialProps
    var Tag.noWrap: Boolean? by materialProps
    var Tag.paragraph: Boolean? by materialProps
    var Tag.theme: MuiTheme? by materialProps
    var Tag.variant: TypographyVariant? by materialProps

    fun Tag.variantMapping(block: VariantMapping.() -> Unit) { variantMapping = jsObject(block) }
}
