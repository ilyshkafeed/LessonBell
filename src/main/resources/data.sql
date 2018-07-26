insert into `organization` (`id`,`version`,`name`, `full_name`, `inn`, `kpp`, `address`, `phone`, `is_active`) values
  (1, 0, 'Shanahan',  'Shanahan LLC',     '2303924823', '507516285', '05924 Parkside Plaza',    '+7 444 123-96-24',  1),
  (2, 0, 'HP',        'Heathcote-Price',  '7956748358', '208752490', '19885 Southridge Plaza',  '+7 811 283-74-27',  1),
  (3, 0, 'BL',        'Beer-Legros',      '4429499323', '141146610', '73 Artisan Point',        '+7 178 446-77-99',   1);


insert into `office` (`id`,`version`,`organization_id`, `name`, `address`, `phone`, `is_active`,) values
  (1, 0, 1,  'Главный',        '05924 Parkside Plaza',    '+7 444 123-96-24',  1),
  (2, 0, 1,  'Нижегородский',  '19885 Southridge Plaza',  '+7 811 283-74-27',  1),
  (3, 0, 2,  'Главный',        '73 Artisan Point',        '+7 178 446-77-99',   1);

insert into `doc` (`id`,`version`,`code`, `name`) values
  (1, 0, 3,   'Свидетельство о рождении'),
  (2, 0, 7,   'Военный биле'),
  (3, 0, 21,  'Паспорт гражданина Российской Федерации');

insert into `country` (`id`,`version`,`code`, `name`) values
  (1,0, 643, 'Российская Федерация');

insert into `user` (`id`,`version`, `office_id`, `first_name`, `last_name`, `middle_name`, `position`,`phone`, `doc_code`, `doc_number`, `doc_date`, `citizenship_code`, `is_identified`) VALUES
  (1, 0, 1, 'Илья',  'Мослов',   'Петрович', 'Ведущий программист','+7 801 123-45-67', 3,  '1234 123456',  PARSEDATETIME('02/02/2001','dd/mm/yyyy'), 1, 1),
  (2, 0, 1, 'Артем', 'Сорокин',  'Людовик',  'Программист',        '+7 802 123-45-67', 3,  '1234 123456',  PARSEDATETIME('02/02/2001','dd/mm/yyyy'), 1, 1),
  (3, 0, 3, 'Ваня',  'Максимов', 'Зайцевич', 'Директор',           '+7 803 123-45-67', 3,  '1234 123456',  PARSEDATETIME('02/02/2001','dd/mm/yyyy'), 1, 1);
