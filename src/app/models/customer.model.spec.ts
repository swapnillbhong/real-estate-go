import { Customer } from './customer.model';

describe('Customermodel', () => {
  it('should create an instance', () => {
    expect(new Customer()).toBeTruthy();
  });
});
