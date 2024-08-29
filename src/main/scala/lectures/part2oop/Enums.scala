package lectures.part2oop

object Enums extends App {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // can also declare methods
    def openDocument: Unit = {
      if (this == READ) println("opening the document...")
      else println("cannot open document")
    }
  }

  val somePermissions: Permissions = Permissions.READ

  println(somePermissions)

  somePermissions.openDocument

  // usage with constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = {
      PermissionsWithBits.NONE
    }
  }

  // standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  println(somePermissionsOrdinal)

  val allPermissions = Permissions.values
  println(allPermissions.mkString("Array(", ", ", ")"))

  val readPermission: Permissions = Permissions.valueOf("READ")
  println(readPermission)
}
