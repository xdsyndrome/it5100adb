package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Route.schema ++ Stop.schema ++ Vehicle.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Route
   *  @param routeId Database column route_id SqlType(varchar), Length(256,true)
   *  @param stops Database column stops SqlType(varchar), Length(256,true) */
  case class RouteRow(routeId: String, stops: String)
  /** GetResult implicit for fetching RouteRow objects using plain SQL queries */
  implicit def GetResultRouteRow(implicit e0: GR[String]): GR[RouteRow] = GR{
    prs => import prs._
    RouteRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table route. Objects of this class serve as prototypes for rows in queries. */
  class Route(_tableTag: Tag) extends profile.api.Table[RouteRow](_tableTag, "route") {
    def * = (routeId, stops) <> (RouteRow.tupled, RouteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(routeId), Rep.Some(stops))).shaped.<>({r=>import r._; _1.map(_=> RouteRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column route_id SqlType(varchar), Length(256,true) */
    val routeId: Rep[String] = column[String]("route_id", O.Length(256,varying=true))
    /** Database column stops SqlType(varchar), Length(256,true) */
    val stops: Rep[String] = column[String]("stops", O.Length(256,varying=true))
  }
  /** Collection-like TableQuery object for table Route */
  lazy val Route = new TableQuery(tag => new Route(tag))

  /** Entity class storing rows of table Stop
   *  @param stopName Database column stop_name SqlType(varchar), Length(256,true)
   *  @param coordinates Database column coordinates SqlType(varchar), Length(256,true) */
  case class StopRow(stopName: String, coordinates: String)
  /** GetResult implicit for fetching StopRow objects using plain SQL queries */
  implicit def GetResultStopRow(implicit e0: GR[String]): GR[StopRow] = GR{
    prs => import prs._
    StopRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table stop. Objects of this class serve as prototypes for rows in queries. */
  class Stop(_tableTag: Tag) extends profile.api.Table[StopRow](_tableTag, "stop") {
    def * = (stopName, coordinates) <> (StopRow.tupled, StopRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(stopName), Rep.Some(coordinates))).shaped.<>({r=>import r._; _1.map(_=> StopRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column stop_name SqlType(varchar), Length(256,true) */
    val stopName: Rep[String] = column[String]("stop_name", O.Length(256,varying=true))
    /** Database column coordinates SqlType(varchar), Length(256,true) */
    val coordinates: Rep[String] = column[String]("coordinates", O.Length(256,varying=true))
  }
  /** Collection-like TableQuery object for table Stop */
  lazy val Stop = new TableQuery(tag => new Stop(tag))

  /** Entity class storing rows of table Vehicle
   *  @param vehicleId Database column vehicle_id SqlType(varchar), Length(256,true)
   *  @param totalStorage Database column total_storage SqlType(float8) */
  case class VehicleRow(vehicleId: String, totalStorage: Double)
  /** GetResult implicit for fetching VehicleRow objects using plain SQL queries */
  implicit def GetResultVehicleRow(implicit e0: GR[String], e1: GR[Double]): GR[VehicleRow] = GR{
    prs => import prs._
    VehicleRow.tupled((<<[String], <<[Double]))
  }
  /** Table description of table vehicle. Objects of this class serve as prototypes for rows in queries. */
  class Vehicle(_tableTag: Tag) extends profile.api.Table[VehicleRow](_tableTag, "vehicle") {
    def * = (vehicleId, totalStorage) <> (VehicleRow.tupled, VehicleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(vehicleId), Rep.Some(totalStorage))).shaped.<>({r=>import r._; _1.map(_=> VehicleRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column vehicle_id SqlType(varchar), Length(256,true) */
    val vehicleId: Rep[String] = column[String]("vehicle_id", O.Length(256,varying=true))
    /** Database column total_storage SqlType(float8) */
    val totalStorage: Rep[Double] = column[Double]("total_storage")
  }
  /** Collection-like TableQuery object for table Vehicle */
  lazy val Vehicle = new TableQuery(tag => new Vehicle(tag))
}
