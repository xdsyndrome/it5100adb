CREATE TABLE activevehicles(
    active_vehicle_id varchar(256) NOT NULL,
    route_id varchar(256) NOT NULL,
    parcel_id varchar(256) NOT NULL
);

CREATE TABLE parcel(
  parcel_id varchar(256) NOT NULL,
  pickup_location varchar(256) NOT NULL,
  destination varchar(256) NOT NULL
);

CREATE TABLE route (
  route_id varchar(256) NOT NULL,
  stops varchar(256) NOT NULL
);

CREATE TABLE stop (
  stop_name varchar(256) NOT NULL,
  coordinates varchar(256) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--
/*
CREATE TABLE vehicle (
    vehicle_id varchar(256) NOT NULL
);

ALTER TABLE activevehicles ADD PRIMARY KEY (active_vehicle_id);

ALTER TABLE parcel ADD PRIMARY KEY (parcel_id);

ALTER TABLE route ADD PRIMARY KEY (route_id);

--
-- Indexes for table `stop`
--
ALTER TABLE stop ADD PRIMARY KEY (stop_name);

--
-- Indexes for table `vehicle`
--
ALTER TABLE vehicle ADD PRIMARY KEY (`vehicle_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
*/