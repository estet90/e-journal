#!/bin/bash
psql -U postgres -h localhost -d ejournal -f createdb.sql -o createdb.log