package sangria.macros

import scala.language.experimental.{macros => `scalac, please just let me do it!`}

import sangria.schema.{InputObjectType, EnumType, ObjectType}


package object derive {
  def deriveContextObjectType[Ctx, CtxVal, Val](fn: Ctx => CtxVal, config: DeriveObjectSetting[Ctx, Val]*): ObjectType[Ctx, Val] =
    macro DeriveObjectTypeMacro.deriveContextObjectType[Ctx, CtxVal, Val]

  def deriveObjectType[Ctx, Val](config: DeriveObjectSetting[Ctx, Val]*): ObjectType[Ctx, Val] =
    macro DeriveObjectTypeMacro.deriveNormalObjectType[Ctx, Val]

  def deriveInputObjectType[T](config: DeriveInputObjectSetting*): InputObjectType[T] =
    macro DeriveInputObjectTypeMacro.deriveInputObjectType[T]

  def deriveEnumType[T](config: DeriveEnumSetting*): EnumType[T] =
    macro DeriveEnumTypeMacro.deriveEnumType[T]
}
