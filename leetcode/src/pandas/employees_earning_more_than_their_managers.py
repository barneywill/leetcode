import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    df = employee.join(employee.set_index('id'), on='managerId', how='left', lsuffix='_l', rsuffix='_r')
    df = df[df.salary_l > df.salary_r][['name_l']]
    df.rename(columns={'name_l':'Employee'}, inplace=True)
    return df