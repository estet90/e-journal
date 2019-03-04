INSERT INTO ejournal.period
  (id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = '1-я четверть'), '2018-09-01', '2018-10-28');
INSERT INTO ejournal.period
(id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = '2-я четверть'), '2018-11-05', '2018-12-31');
INSERT INTO ejournal.period
(id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = '3-я четверть'), '2018-01-14', '2018-03-31');
INSERT INTO ejournal.period
(id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = '4-я четверть'), '2018-04-08', '2018-05-31');
INSERT INTO ejournal.period
(id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = '1-е полугодие'), '2018-09-01', '2018-12-31');
INSERT INTO ejournal.period
(id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = '2-е полугодие'), '2019-01-14', '2018-05-31');
INSERT INTO ejournal.period
(id_period_type, date_start, date_end)
VALUES ((SELECT id FROM ejournal.period_type WHERE name = 'Год'), '2019-09-01', '2018-05-31');