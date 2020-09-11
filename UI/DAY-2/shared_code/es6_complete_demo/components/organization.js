export class Employee {
	constructor(id, name, salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	get salary() {
		return this._salary;
	}
	set salary(value) {
		this._salary = value;
	}
	
	toString() {
		return this.id +  '-' + this.name + '-' + this.salary;
	}
}

export class Manager extends Employee {
	constructor(id, name, salary, incentive) {
		super(id, name, salary);
		this.incentive = incentive;
	}
	toString() {
		return super.toString() + '-' + this.incentive;
	}
}

export function testOrganization() {
	let emp = new Manager(12, 'Tonny', 12000, 3000);
	console.log('Manager salary = ', emp.salary);
}