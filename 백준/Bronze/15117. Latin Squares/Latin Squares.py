import sys

def read_input():
    """입력을 읽어서 변환된 행렬 반환"""
    input_func = sys.stdin.readline
    n = int(input_func())
    matrix = []
    
    for _ in range(n):
        row = []
        line = input_func().strip()
        for char in line:
            if char.isalpha():
                row.append(ord(char) - ord('A') + 10)
            else:
                row.append(int(char))
        matrix.append(row)
    
    return n, matrix

def is_valid_latin_square(n, matrix):
    """라틴 정사각형이 유효한지 검사"""
    # 행 검사
    for i in range(n):
        if len(set(matrix[i])) != n:
            return False
    
    # 열 검사
    for j in range(n):
        column = [matrix[i][j] for i in range(n)]
        if len(set(column)) != n:
            return False
    
    return True

def is_reduced_latin_square(n, matrix):
    """축소된 라틴 정사각형인지 검사"""
    # 첫 번째 행과 첫 번째 열이 0, 1, 2, ..., n-1 순서인지 확인
    first_row = matrix[0]
    first_col = [matrix[i][0] for i in range(n)]
    
    expected = list(range(n))
    return first_row == expected and first_col == expected

def main():
    n, matrix = read_input()
    
    # 라틴 정사각형 유효성 검사
    if not is_valid_latin_square(n, matrix):
        print('No')
        return
    
    # 축소된 라틴 정사각형인지 검사
    if is_reduced_latin_square(n, matrix):
        print('Reduced')
    else:
        print('Not Reduced')

if __name__ == "__main__":
    main()