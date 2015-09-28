def fibber(stop):
    sequence = [0,1]
    for num in range(0, stop):
        init = sequence[num] + sequence[num+1]
        sequence.append(init)
        print sequence

if __name__ == '__main__':
    fibber(10000)
