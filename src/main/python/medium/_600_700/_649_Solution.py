# 649. Dota2 Senate
class _649_Solution:
    def predictPartyVictory(self, senate: str) -> str:
        rq, dq, size = [], [], len(senate)
        for i, s in enumerate(senate):
            if s == 'R':
                rq.append(i)
            else:
                dq.append(i)
        while rq and dq:
            c0, c1 = rq.pop(0), dq.pop(0)
            if c0 < c1:
                rq.append(c0 + size)
            else:
                dq.append(c1 + size)
        return "Radiant" if rq else "Dire"
