insert into `organization` (`id`,`name`, `full_name`, `inn`, `kpp`, `address`, `phone`, `is_active`) values
  (1, 'Shanahan',  'Shanahan LLC',     '2303924823', '507516285', '05924 Parkside Plaza',    '+670 (444) 123-9624',  1),
  (2, 'HP',        'Heathcote-Price',  '7956748358', '208752490', '19885 Southridge Plaza',  '+358 (811) 283-7427',  1),
  (3, 'BL',        'Beer-Legros',      '4429499323', '141146610', '73 Artisan Point',        '+63 (178) 446-7799',   1);


insert into `office` (`id`,`organization_id`, `name`, `address`, `phone`, `is_active`,) values
  (1, 1,  'Главный',        '05924 Parkside Plaza',    '+670 (444) 123-9624',  1),
  (2, 1,  'Нижегородский',  '19885 Southridge Plaza',  '+358 (811) 283-7427',  1),
  (3, 2,  'Главный',        '73 Artisan Point',        '+63 (178) 446-7799',   1);

insert into `doc` (`id`,`code`, `name`) values
  (1,3,   'Свидетельство о рождении'),
  (2,7,   'Военный биле'),
  (3,21,  'Паспорт гражданина Российской Федерации');

insert into `country` (`id`,`code`, `name`) values
  (1,643, 'Российская Федерация');

insert into `user` (`id`, `office_id`, `first_name`, `last_name`, `middle_name`, `position`, `doc_code`, `doc_number`, `doc_date`, `citizenship_code`, `is_identified`) VALUES
  (1,1,'Илья',  'Мослов',   'Петрович', 'Ведущий программист', 3,  '1234 123456',  PARSEDATETIME('02/02/2001','dd/mm/yyyy'), 1, 1),
  (2,1,'Артем', 'Сорокин',  'Людовик',  'Программист',         3,  '1234 123456',  PARSEDATETIME('02/02/2001','dd/mm/yyyy'), 1, 1),
  (3,3,'Ваня',  'Максимов', 'Зайцевич', 'Директор',            3,  '1234 123456',  PARSEDATETIME('02/02/2001','dd/mm/yyyy'), 1, 1);
