drop user database payrolldb;

create user if not exists 'magna' with encrypted password 'm18job,,' createdb;
create if not exists database payrolldb  with owner = payroll;

grant all privileges on database payrolldb to payroll