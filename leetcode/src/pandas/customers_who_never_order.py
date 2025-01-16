import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    df = customers.join(orders.set_index('customerId'), on=['id'], how='left', lsuffix='_l', rsuffix='_r')
    df = df[df.id_r.isnull()][['name']]
    df.rename(columns={'name':'Customers'}, inplace=True)
    return df