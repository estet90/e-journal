#!/bin/bash
psql -U postgres -h localhost -d ejournal -f ejournal.sql -o createdb.log