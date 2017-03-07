CREATE KEYSPACE UserListKeySpace WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1};

USE UserListKeySpace;

CREATE TABLE User (
	key UUID PRIMARY KEY,
	username TEXT,
	password TEXT
);